import { connect } from "react-redux";
import { incrementCounter, decrementCounter } from "../actions/actions.js";

const Counter = ({ count, increment, decrement }) => (
  <>
    <p>Count: {count}</p>
    <div className="flex gap-2">
      <button
        className="px-4 py-2 rounded bg-blue-500 text-white"
        onClick={increment}
      >
        Increment
      </button>
      <button
        className="px-4 py-2 rounded bg-yellow-400 text-white"
        onClick={decrement}
      >
        Decrement
      </button>
    </div>
  </>
);

const mapStateToProps = (state) => ({
  count: state.counter,
});

const mapDispatchToProps = {
  increment: incrementCounter,
  decrement: decrementCounter,
};

export default connect(mapStateToProps, mapDispatchToProps)(Counter);
